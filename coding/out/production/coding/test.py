# Online Python compiler (interpreter) to run Python online.
# Write Python 3 code in this online editor and run it.
import xmltodict

inputbuffer =   "<Student><contact><address>abc</address><address>abc</address><address>abc</address></contact></Student>"
doc1    =   xmltodict.parse(inputbuffer)
print(type(doc1['Student']))

for st in doc1['Student']['contact']['address']:
    print(st)

str2    =   "<Student><Name>somil</Name></Student>"
doc2    =   xmltodict.parse(str2)
print( type(doc2['Student']['Name']))
for st in doc2['Student']['Name']:

    print(st)
