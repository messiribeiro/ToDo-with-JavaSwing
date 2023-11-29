/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolist;

import javax.swing.DefaultListModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author micae
 */
public class Task {
    
    
    public void addTask(String taskText, JList tasksContainer) {
        
        // Obter o modelo do JList
        DefaultListModel<String> listModel = (DefaultListModel<String>) tasksContainer.getModel();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        // Adicionar a nova tarefa ao modelo
        listModel.addElement(String.format("📝 %s - Criada em %s", taskText, dateTime.format(formatter)));
    }
    
    public void removeTask(JList tasksContainer) {
           // Obter o índice do item selecionado
        int selectedIndex = tasksContainer.getSelectedIndex();

        // Certificar-se de que há um item selecionado
        if (selectedIndex != -1) {
            // Remover o item do modelo
            DefaultListModel<String> listModel = (DefaultListModel<String>) tasksContainer.getModel();
            System.out.println(tasksContainer.getModel());
            System.out.println(listModel);

            listModel.remove(selectedIndex);
        }else {
        // Se nenhum item estiver selecionado, exibir uma janela de aviso
            JOptionPane.showMessageDialog(tasksContainer, "Nenhum item selecionado para remover", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
}
