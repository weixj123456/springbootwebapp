#coding:utf-8
import os
import  ConfigParser

class ReadConig:
    proDir = os.path.split(os.path.realpath(__file__))[0]
    configPath = os.path.join(proDir, "../config", "config.ini")
    def __init__(self,configPath=configPath):
        self.cf=ConfigParser.RawConfigParser()
        self.cf.read(configPath)

    def get_value(self,list,key):
        """
        读取配置文件
        :param list:配置文件集名
        :param key: 集中键名
        :return:对应值
        """
        value=self.cf.get(list,key)
        return value

