#%%
import cv2
from matplotlib import cm
import matplotlib.pyplot as plt
import numpy as np
#%%
#创建图像锐化的核
kernel = np.array([[0, -1, 0],\
                    [-1, 5,-1],\
                    [0, -1, 0]])
#%%
#加载彩色图像,读取为ndarray数组并进行查看
image_grey = cv2.imread("/root/Github_files/python_All/Dataset/OpenCV001temp1.jpg",cv2.IMREAD_GRAYSCALE)
plt.imshow(image_grey)
#%%
#锐化图像
image_grey_sharp = cv2.filter2D(image_grey,-1,kernel)
plt.axis("off")##关闭坐标轴
plt.imshow(image_grey_sharp)
#%%
#灰度图提升对比度
image_grey_enhanced = cv2.equalizeHist(image_grey)
plt.imshow(image_grey_enhanced,cmap="gray")
#%%
#彩色图提升对比度,读取
image_color = cv2.imread("/root/Github_files/python_All/Dataset/OpenCV001temp1.jpg")
plt.imshow(image_color)
#%%
#step1:转换为YUV 格式
image_color_YUV = cv2.cvtColor(image_color,cv2.COLOR_BGR2YUV)
plt.imshow(image_color_YUV)
#%%
#step2:对图像应用直方图均衡
"""简单来说，就是它会转换图像，使
像素强度的分布范围更广"""
image_color_YUV[:][:][0] = cv2.equalizeHist(image_color_YUV[:][:][0])
plt.imshow(image_color_YUV)
#%%
#step3:转换成RGB 格式
image_color_RGB = cv2.cvtColor(image_color_YUV,cv2.COLOR_YUV2RGB)
plt.imshow(image_color_RGB)
#%%
