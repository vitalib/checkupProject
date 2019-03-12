def sum(x, y):
	return x + y;

try:
	file_in = open("in.txt")
	text = file_in.read()
	nums = text.split(' ')
	print(sum(int(nums[0]), int(nums[1])))
	file_in.close()
except:
	print("Err!")

