#%%
import os
if __name__ == '__main__':
    print ('current Process (%s) start ...'%(os.getpid()))
    """
    fork方法来自于Unix/Linux操作系统中提供的一个fork系统调用，这个方法非常特殊。
    普通的方法都是调用一次，返回一次，
    而fork方法是调用一次，返回两次，原因在于操作系统将当前进程（父进程）复制出一份进程（子进程），
    这两个进程几乎完全相同，子进程中永远返回0，父进程中返回的是子进程的ID
    getpid方法用于获取当前进程的ID，getppid方法用于获取父进程的ID
    """
    pid = os.fork()
    if pid < 0:
        print ('error in fork')
    elif pid == 0:
        print ('I am child process(%s) and my parent process is (%s)'%(os.getpid(),os.getppid()))
    else:
        print ('I(%s) created a chlid process (%s).'%(os.getpid(),pid))


# %%
