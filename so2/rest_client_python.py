import urllib2
import xml
import xml.dom.minidom
import json


def simple_service_request_XML(url):
  req = urllib2.Request(url)
  req.add_header("Accept","application/xml")
  return urllib2.urlopen(req).read()

def simple_service_request_JSON(url):
  req = urllib2.Request(url)
  req.add_header("Accept","application/json")
  return urllib2.urlopen(req).read()

# quick XML parse
def parseXML_turma(xml_response):
  xmldoc= xml.dom.minidom.parseString(xml_response)
  itemlist = xmldoc.getElementsByTagName('alunos') 
  for aluno in itemlist:
    print "\t",aluno.getElementsByTagName('nome')[0].firstChild.nodeValue,aluno.getElementsByTagName('numero')[0].firstChild.nodeValue

def parseJSON_turma(json_text):
  jsonObj= json.loads(json_text)
  turma= jsonObj.get("alunos")
  for aluno in turma:
    print "\t%s - %s" %(aluno.get('nome'),aluno.get('numero'))




# MAIN ############################################

url = 'http://localhost:9200/so2/turma'

# test a request, and show answer data
response= simple_service_request_XML(url)
print response
parseXML_turma(response)

# the same, using JSON data format
response= simple_service_request_JSON(url)
print response
parseJSON_turma(response)
