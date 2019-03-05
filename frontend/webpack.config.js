const path = require("path");
const mode =
  process.env.NODE_ENV === "production" ? "production" : "development";
const HtmlWebpackPlugin = require("html-webpack-plugin");
const CopyWebpackPlugin = require("copy-webpack-plugin");

module.exports = {
  entry: path.resolve(__dirname, "src", "index.jsx"),
  mode: mode,
  output: {
    filename: "bundle.js",
    path: path.resolve(__dirname, "dist"),
  },
  resolve: {
    extensions: [".js", ".jsx"],
  },
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        enforce: "pre",
        use: {
          loader: "eslint-loader",
          options: {
            emitWarning: true,
            configFIle: "./.eslintrc.json",
          },
        },
      },
      {
        test: /\.jsx?$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: ["@babel/preset-env", "@babel/preset-react"],
          },
        },
      },
      {
        test: /\.css/,
        use: ["style-loader", "css-loader"],
      },
    ],
  },
  plugins: [
    new HtmlWebpackPlugin({
      filename: "index.html",
      template: "public/index.html",
    }),
    new CopyWebpackPlugin([
      {
        from: "./public/img",
        to: "./img",
      },
    ]),
  ],
};
