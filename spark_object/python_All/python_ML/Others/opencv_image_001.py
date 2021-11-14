#%%
from matplotlib import cm
import numpy as np
import cv2
import matplotlib.pyplot as plt
#%%
image = cv2.imread("/root/Github_files/python_All/Dataset/OpenCV001.jpg",cv2.IMREAD_GRAYSCALE)
#%%
plt.imshow(image, cmap="gray"), plt.axis("off")
plt.show()
#%%
print(type(image))##<class 'numpy.ndarray'>
image.shape##像素大小：(655, 1000)
#%%
image[250][250]##查看该点的像素点信息
#%%
images = image[0:450][:]
images.shape
#%%
plt.imshow(images,cmap="gray")
plt.axis("off")
plt.show()
#%%
#以彩色模式加载图像并进行裁剪
image_colr = cv2.imread("/root/Github_files/python_All/Dataset/OpenCV001.jpg",cv2.IMREAD_COLOR)
image_colr[250][250]##array([188, 212, 212], dtype=uint8)
#%%
image_colrs = image_colr[0:450][:][:]
image_colrs.shape
#%%
plt.imshow(image_colrs)
plt.axis("off")
plt.show()
#%%
#sava image
cv2.imwrite("/root/Github_files/python_All/Dataset/OpenCV001temp1.jpg",image_colrs)
#  True
#%%
#改变图像大小，是像素的大小
image_gray = cv2.imread("/root/Github_files/python_All/Dataset/OpenCV001temp1.jpg",cv2.IMREAD_GRAYSCALE)
image_gray_50X50 = cv2.resize(image_gray,(100,100)) 
plt.imshow(image_gray_50X50,cmap="gray")
plt.axis("off")
plt.show()
#%%
"""
    平滑处理图像就是将每个像素的值变换为其相邻像素的平均值
    相邻像素和所执行的操作在数学上被表示为一个核
    这个核的大小决定了平滑的程度
    核越大，产生的图像就越平滑
"""
#%%
image_gray_blurry = cv2.blur(image_gray_50X50,(10,10))
plt.imshow(image_gray_blurry, cmap="gray")
plt.axis("off")
plt.show()

#%%
#创建核
kernel = np.ones((5,5))/25.0
kernel
#%%
#应用核
image_kernel = cv2.filter2D(image_gray_50X50, -1, kernel)
#%%
plt.imshow(image_kernel,cmap="gray")
#plt.axis("off")
plt.xticks([])
plt.yticks([])
plt.show()
#%%

