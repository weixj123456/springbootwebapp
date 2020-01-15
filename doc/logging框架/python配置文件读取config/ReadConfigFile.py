# encoding=utf-8

import ConfigParser

class ReadConfigFile(object):

    def get_value(self):

        config = ConfigParser.ConfigParser()
        config.read("configfile.ini")
        browserName = config.get('browserType','browserName')
        browserName1 = config.get('browserType','browserTyp')
        account = config.get('accountType','user')
        language = config.get('languageType','language')
        country = config.get('countryType','country')

        return [browserName,browserName1,account,language,country]


trcf = ReadConfigFile()
print '***********************************'
print trcf.get_value()
print '***********************************'