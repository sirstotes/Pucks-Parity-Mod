import os
import shutil
for filename in os.listdir("."):
	if filename.endswith("_polished.png"):
		#shutil.copy(filename, "chiseled_"+filename)
		os.rename(filename, "polished_"+filename[0:-13]+".png")
		#exit()