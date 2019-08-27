/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import org.apache.axis.encoding.XMLType;
import javax.xml.rpc.ParameterMode;


//mport javax.xml.rpc.ParameterMode;


/**
 *
 * @author LENPOVO
 */
public class CalculControl {
    public CalculControl(){
}
    public String multiple(Calculator cal){
String result = null;
try {
result = calculate("MUl", cal);                        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
return result;
}
    
    public String div(Calculator cal){
String result = null;
try {
result = calculate("Division", cal);                        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
return result;
}
    
    public String add(Calculator cal){
String result = null;
try {
result = calculate("Add", cal);                        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
return result;
}
    
    public String sub(Calculator cal){
String result = null;
try {
result = calculate("Sub", cal);                        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
return result;
}
    
    public String calculate(String methodName, Calculator cal){
String result = "";
String endpointURL = "http://localhost:8080/axis/Calculator.jws";
Service service = new Service();
try{
Call call = (Call)service.createCall();
call.setTargetEndpointAddress(new java.net.URL(endpointURL));
call.setOperationName(methodName);
call.addParameter("a", XMLType.XSD_DOUBLE, 
ParameterMode.IN);
call.addParameter("b", XMLType.XSD_DOUBLE, 
ParameterMode.IN);
call.setReturnType(XMLType.XSD_STRING);
result = (String)call.invoke(new Object[]
{cal.getFirstnumber(),cal.getSecondnumber()});
}catch(Exception ex){
ex.printStackTrace();
}
return result;
}
}
