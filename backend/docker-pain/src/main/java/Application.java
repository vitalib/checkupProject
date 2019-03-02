import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.WaitContainerResultCallback;

public class Application {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    DockerClient dockerClient = DockerClientBuilder.getInstance().build();
    Long memSize = new Long(5000000);
    String pwd = System.getProperty("user.dir");
    Volume dataDirVolume = new Volume("/app/data");
    CreateContainerResponse container = dockerClient.createContainerCmd("py_image")
    //CreateContainerResponse container = dockerClient.createContainerCmd("java_image")
    //CreateContainerResponse container = dockerClient.createContainerCmd("js_image")
      .withMemory(memSize)
      .withBinds(new Bind(pwd + "/../docker-images/py_container/py_data", dataDirVolume))
      //.withBinds(new Bind(pwd + "/../docker-images/java_container/java_data", dataDirVolume))
      //.withBinds(new Bind(pwd + "/../docker-images/js_container/js_data", dataDirVolume))
      .exec();

    dockerClient.startContainerCmd(container.getId()).exec();

    int code = dockerClient.waitContainerCmd(container.getId())
      .exec(new WaitContainerResultCallback())
      .awaitStatusCode();
    long finish = System.currentTimeMillis();

    dockerClient.removeContainerCmd(container.getId()).exec();

    System.out.println((finish - start)/1000 + "s");
    System.out.println(code);

  }
}