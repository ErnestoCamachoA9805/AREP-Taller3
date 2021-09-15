package edu.escuelaing.Taller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import edu.escuelaing.Taller.httpService.HttpServer;
import edu.escuelaing.Taller.nextspring.Component;

/**
 * El get componentes fue desarrollado junto a sebastian herrera.
 */
public class WebApp {
    public static void main(String[] args){
        try {
            HttpServer.getInstance().startServer((getComponents(new File("./src/main/java/"+WebApp.class.getPackageName().replace(".", "/")))));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getComponents(File file){
        List<String> ans = new ArrayList<>();
        if(file.isDirectory()){
            for(File fileEntry:file.listFiles()){
                ans.addAll(getComponents(fileEntry));
            }
        }else{
            if(file.getName().endsWith(".java")){
                String [] pathArr = file.getPath().replace(".java", "").split("\\\\");
                String clas="";
                for(int i=4;i<pathArr.length;i++){
                    clas+=(i==pathArr.length-1)? pathArr[i]:pathArr[i]+".";
                }
                try{
                    Class c = Class.forName(clas);
                    if(c.isAnnotationPresent(Component.class)){
                        ans.add(clas);
                    }
                }catch(ClassNotFoundException e) {
                    Logger.getLogger(WebApp.class.getName()).log(Level.SEVERE, "Component not found", e);
                }
            }
        }
        return ans;
    }   
}