/*
    Structorizer
    A little tool which you can use to create Nassi-Schneiderman Diagrams (NSD)

    Copyright (C) 2009  Bob Fisch

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or any
    later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package lu.fisch.structorizer.gui;

/******************************************************************************************************
 *
 *      Author:         Bob Fisch
 *
 *      Description:    This the dialog that allows editing the properties of any element.
 *
 ******************************************************************************************************
 *
 *      Revision List
 *
 *      Author          Date			Description
 *      ------			----			-----------
 *      Bob Fisch       2007.12.23      First Issue
 *      Kay Gürtzig     2015-10-12      A checkbox added for breakpoint control (KGU#43)
 *      Kay Gürtzig     2015-10-14      Element-class-specific language support (KGU#42)
 *      Kay Gürtzig     2015-10-25      Hook for subclassing added to method create() (KGU#3)
 *
 ******************************************************************************************************
 *
 *      Comment:		/
 *
 ******************************************************************************************************///


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import lu.fisch.structorizer.elements.ElementCounter;
import lu.fisch.utils.StringList;


public class CounterBox extends LangDialog implements ActionListener, KeyListener
{
    public boolean OK = false;
    
    // KGU#3 2015-11-03: Some of the controls had to be made public in order to allow language support for subclasses 
    // Buttons
    public JButton btnOK = new JButton("OK"); 
    public JButton btnCancel = new JButton("Cancel"); 
	
    // Labels
    ElementCounter elec = new ElementCounter();
    public JLabel lblText = new JLabel("Element Count:");
    public JLabel lb2Text = new JLabel("Instruction #: "+ elec.elementscounter[0]);
    public JLabel lb3Text = new JLabel("If Statement#: "+ elec.elementscounter[1]);
    public JLabel lb4Text = new JLabel("Case Statement#: "+elec.elementscounter[2]);
    public JLabel lb5Text = new JLabel("For loop#: "+elec.elementscounter[3]);
    public JLabel lb6Text = new JLabel("While loop#: "+elec.elementscounter[4]);
    public JLabel lb7Text = new JLabel("Repeat loop#: "+elec.elementscounter[5]);
    public JLabel lb8Text = new JLabel("Endless loop#: "+elec.elementscounter[6]);
    public JLabel lb9Text = new JLabel("Call Statement#: "+elec.elementscounter[7]);
    public JLabel lb10Text = new JLabel("Jump Statement#: "+elec.elementscounter[8]);
    public JLabel lb11Text = new JLabel("Parallel Statement#: "+elec.elementscounter[9]);
    
    


    private void create()
    {
            // set window title
            setTitle("Content");
            // set layout (OS default)
            setLayout(null);
            // set windows size
            setSize(500, 400);
            // show form
            setVisible(false);
            // set action to perfom if closed
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // set icon
            btnOK.addActionListener(this);
            btnCancel.addActionListener(this);

            btnOK.addKeyListener(this);
            btnCancel.addKeyListener(this);
            
            addKeyListener(this);

            Border emptyBorder = BorderFactory.createEmptyBorder(4,4,4,4);
           

            JPanel pnPanel0 = new JPanel();
            GridBagLayout gbPanel0 = new GridBagLayout();
            GridBagConstraints gbcPanel0 = new GridBagConstraints();
            gbcPanel0.insets=new Insets(10,10, 0,10);
            pnPanel0.setLayout( gbPanel0 );
            
            // START KGU#3 2015-10-24: Open opportunities for subclasses
            createPanelTop(pnPanel0, gbPanel0, gbcPanel0);
            
            JPanel pnPanel1 = new JPanel();
            GridBagLayout gbPanel1 = new GridBagLayout();
            GridBagConstraints gbcPanel1 = new GridBagConstraints();
            gbcPanel1.insets=new Insets(10,10,0,10);
            pnPanel1.setLayout( gbPanel1 );
            // END KGU#3 2015-10-24
            
            gbcPanel1.gridx = 1;
            gbcPanel1.gridy = 2;
            gbcPanel1.gridwidth = 18;
            gbcPanel1.gridheight = 7;
            gbcPanel1.fill = GridBagConstraints.BOTH;
            gbcPanel1.weightx = 1;
            gbcPanel1.weighty = 1;
            gbcPanel1.anchor = GridBagConstraints.NORTH;
           

            gbcPanel1.gridx = 1;
            gbcPanel1.gridy = 12;
            gbcPanel1.gridwidth = 18;
            gbcPanel1.gridheight = 4;
            gbcPanel1.fill = GridBagConstraints.BOTH;
            gbcPanel1.weightx = 1;
            gbcPanel1.weighty = 1;
            gbcPanel1.anchor = GridBagConstraints.NORTH;
           

            
            gbcPanel1.gridx = 1;
            gbcPanel1.gridy = 10;
            gbcPanel1.gridwidth = 18;
            gbcPanel1.gridheight = 1;
            gbcPanel1.fill = GridBagConstraints.BOTH;
            gbcPanel1.weightx = 1;
            gbcPanel1.weighty = 0;
            gbcPanel1.anchor = GridBagConstraints.NORTH;
        
            gbcPanel1.gridx = 1;
            gbcPanel1.gridy = 17;
            gbcPanel1.gridwidth = 18;
            gbcPanel1.gridheight = 1;
            gbcPanel1.fill = GridBagConstraints.BOTH;
            gbcPanel1.weightx = 1;
            gbcPanel1.weighty = 0;
            gbcPanel1.anchor = GridBagConstraints.NORTH;
         
            gbcPanel1.insets=new Insets(10,10,10,10);

            //createExitButtons(gridbase)
            gbcPanel1.gridx = 1;
            gbcPanel1.gridy = 26;
            gbcPanel1.gridwidth = 7;
            gbcPanel1.gridheight = 1;
            gbcPanel1.fill = GridBagConstraints.BOTH;
            gbcPanel1.weightx = 1;
            gbcPanel1.weighty = 0;
            gbcPanel1.anchor = GridBagConstraints.NORTH;
            gbPanel1.setConstraints( btnCancel, gbcPanel1 );
            pnPanel1.add( btnCancel );

            // START KGU#3 2015-10-31: The new gridx causes no difference here but fits better for InputBoxFor
            gbcPanel1.gridx = 12;
            //gbcPanel1.gridx = 8;
            // END KGU#3 2015-10-31
            gbcPanel1.gridy = 26;
            // START KGU#3 2015-10-31: The new gridwidth causes no difference here but fits better for InputBoxFor
            gbcPanel1.gridwidth = 7;
    		//gbcPanel1.gridwidth = GridBagConstraints.REMAINDER;
    		// END KGU#3 2015-10-31
            gbcPanel1.gridheight = 1;
            gbcPanel1.fill = GridBagConstraints.BOTH;
            gbcPanel1.weightx = 1;
            gbcPanel1.weighty = 0;
            gbcPanel1.anchor = GridBagConstraints.NORTH;
            gbPanel1.setConstraints( btnOK, gbcPanel1 );
            pnPanel1.add( btnOK );

            Container container = getContentPane();
            container.setLayout(new BorderLayout());
            container.add(pnPanel0,BorderLayout.NORTH);
            container.add(pnPanel1,BorderLayout.CENTER);

            // START KGU#91 2015-12-04: fix #39 - we leave this for diagram now
            //txtText.requestFocus(true);
            // END KGU#91 2015-12-04
    }
    
    // START KGU#3 2015-10-24: Hook for subclasses
    /**
     * Subclassable method to add specific stuff to the Panel top
     * @param _panel the panel to be enhanced
     * @param _gbc the layout constraints
     * @return number of lines (y units) inserted
     */
    protected int createPanelTop(JPanel _panel, GridBagLayout _gb, GridBagConstraints _gbc)
    {
        _gbc.gridx = 1;
        _gbc.gridy = 1;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lblText, _gbc );
        _panel.add( lblText );
        
        _gbc.gridx = 1;
        _gbc.gridy = 3;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb2Text, _gbc );
        _panel.add( lb2Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 5;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb3Text, _gbc );
        _panel.add( lb3Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 7;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb4Text, _gbc );
        _panel.add( lb4Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 9;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb5Text, _gbc );
        _panel.add( lb5Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 11;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb6Text, _gbc );
        _panel.add( lb6Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 13;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb7Text, _gbc );
        _panel.add( lb7Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 15;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb8Text, _gbc );
        _panel.add( lb8Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 17;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb9Text, _gbc );
        _panel.add( lb9Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 19;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb10Text, _gbc );
        _panel.add( lb10Text );
        
        _gbc.gridx = 1;
        _gbc.gridy = 21;
        _gbc.gridwidth = 18;
        _gbc.gridheight = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        _gbc.weightx = 1;
        _gbc.weighty = 0;
        _gbc.anchor = GridBagConstraints.NORTH;
        _gb.setConstraints( lb11Text, _gbc );
        _panel.add( lb11Text );
        // Return the number of used grid lines such that the calling method may go on there
    	return 1;
    }
    // END KGU#3 2015-10-24


    // listen to actions
    public void actionPerformed(ActionEvent event)
    {
            Object source=event.getSource();

            if (source == btnOK)
            {
                    OK=true;
            }
            else if (source == btnCancel)
            {
                    OK=false;
            }
            setVisible(false);
    }

    public void keyTyped(KeyEvent kevt)
    {
    }
	
    public void keyPressed(KeyEvent e)
    {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
                    OK=false;
                    setVisible(false);
            }
            else if(e.getKeyCode() == KeyEvent.VK_ENTER && (e.isShiftDown() || e.isControlDown()))
            {
                    OK=true;
                    setVisible(false);
            }
    }

    public void keyReleased(KeyEvent ke)
    {
    }
	
    // constructors
    public CounterBox(Frame owner, boolean modal)
    {
        super(owner,modal);
        create();
    }
	
    // constructors
    /*public InputBox()
    {
        super();
	this.setModal(true);
        create();
    }*/

    // START KGU#42 2015-10-14: data-specific title localisation
    /**
     * Replaces the title string by translation if keys match some internal state information
     * @see lu.fisch.structorizer.gui.LangDialog#setLangSpecific(lu.fisch.utils.StringList, java.lang.String)
     */
}