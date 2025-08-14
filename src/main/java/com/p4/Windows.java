package com.p4;
import com.p4.elements.Archive;
import com.p4.elements.Folder;

public class Windows {
    public static void main(String[] args) {
       
        //Creación de archivos y carpetas
        Archive archive1 = new Archive("test1",80); 
        Archive archive2 = new Archive("test2",500); 
        Archive archive3 = new Archive("test3",20); 
        Archive archive4 = new Archive("test4",5); 
        Folder root = new Folder ("Root");
        Folder fol1 = new Folder ("Folder1");
        Folder fol2 = new Folder ("Folder2");
        Folder fol3 = new Folder ("Folder3");
        Folder fol4 = new Folder ("Folder4");
        Folder fol5 = new Folder ("Folder5");
        
        //Funcion Agregar
        root.addFile(fol2);
        root.addFile(fol5);
      
        fol1.addFile(archive1);
        fol1.addFile(fol3);

        fol2.addFile(archive2);
        fol2.addFile(archive3);
        fol2.addFile(fol1);    
                
        //Función Ver carpetas especificas
        System.out.println("Vista carpeta2:");
        fol2.view("");
        System.out.println();

        //Función Ver archivos especificas
        System.out.println("Vista Archivo 1:");
        archive1.view("");
        System.out.println();


        //Función Agregar
        System.out.println("Ejemplo Agregar:");
        fol3.addFile(fol4);
        fol3.addFile(archive4); 
        root.view("");
        System.out.println();

        //Función Renombrar
        System.out.println("Ejemplo Renombrar:");
        archive3.rename("nuevonombre");
        fol2.rename("Principal");
        root.view("");
        System.out.println();

        //Función Borrar
        System.out.println("Ejemplo Borrar:");
        fol2.remove(archive3);
        fol1.remove(fol3); 
        root.view("");
        System.out.println();

        //Función Borrar Ejemplo de error
        System.out.println("Ejemplo Borrar (No se selecciono la carpeta donde esta el archivo):");
        fol2.remove(archive1);
        root.view("");
        System.out.println();

        
        //Función Mover
        System.out.println("Mover:");
        fol2.move(archive2,fol5);
        root.view("");
        System.out.println();
    }
}
