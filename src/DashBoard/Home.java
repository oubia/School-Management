package DashBoard;

import JpanelsEvent.JpanelMouseEvent;
import MultiChat.CallClient;
import ProfHomeCenterContent.ProfClassAdmin;
import SinglotonConnectionnnection.Connecter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CenterConetnet.EtudiantClassAdimn;

import ClasseHomeCenterContent.ClasseClassAdmin;

public class Home extends JFrame implements ActionListener {
	Container container = getContentPane();
	Connection con=Connecter.getCon();

	JPanel left = new JPanel();
	JPanel center = new JPanel();
    JPanel DashHome =  new JPanel();
    JPanel JPProf =  new JPanel();
    JPanel JPEtudiant =  new JPanel();
    JPanel JPClasse =  new JPanel();
    JPanel JPchat = new JPanel();
    
//    center panel
    JPanel JHeader = new JPanel();
    JPanel JPcontentPnae  = new JPanel();

    
    JLabel ProfielName;
    JLabel DashHomeLabel =new JLabel("Home");
    JLabel JPProfLabel =  new JLabel("Professeur");
    JLabel JPEtudiantLabel =  new JLabel("Etudiants");
    JLabel JPClasseLabel =  new JLabel("Classe");
    JLabel JPchatLabel = new JLabel("Chat");

//    JButtons
    
    String name = "";
    
	public Home(String name ) {
		this.name = name;
		this.ProfielName = new JLabel(name);
		setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.setTitle("DashBoard");
        this.setVisible(true);
        this.setBounds(10, 10, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
		
	}
	private void setLayoutManager() {
		container.setLayout(new BorderLayout());
        container.setBackground(getBackgroundWhite());
		left.setLayout(null);

		
	}
	private Color getBackgroundWhite() {
		return Color.white;
	}
	public Color getBackgroundPurpol() {
    	return new java.awt.Color(63, 42, 100);
    }
	
	private void addComponentsToContainer() {
		container.add(left,BorderLayout.WEST);
		container.add(center,BorderLayout.CENTER);
		
		left.setBackground(getBackgroundPurpol());
		left.setPreferredSize(new Dimension(250,HEIGHT));
		
		
		center.setSize(550, HEIGHT);
		center.setBackground(getBackgroundWhite());;
		
		addComponentsToLeftPanels();
		addComponentsToRightPanels();
	}
	private void addComponentsToLeftPanels() {
		ProfielName.setBounds(80,70,100,30);
		ProfielName.setForeground(getBackgroundWhite());
		DashHome.add(DashHomeLabel);
		DashHome.setBackground(getBackgroundWhite());
		DashHome.setBounds(23,140,200,30);
		left.add(DashHome);
		left.add(ProfielName);
		
		JPProf.add(JPProfLabel);
		JPProf.setBackground(getBackgroundWhite());
		JPProf.setBounds(23,180,200,30);
		left.add(JPProf);
		
		JPEtudiant.add(JPEtudiantLabel);
		JPEtudiant.setBackground(getBackgroundWhite());
		JPEtudiant.setBounds(23,220,200,30);
		left.add(JPEtudiant);

		JPClasse.add(JPClasseLabel);
		JPClasse.setBackground(getBackgroundWhite());
		JPClasse.setBounds(23,260,200,30);
		left.add(JPClasse);
		
		JPchat.add(JPchatLabel);
		JPchat.setBackground(getBackgroundWhite());
		JPchat.setBounds(23,300,200,30);
		left.add(JPchat);
		
	}
	
	private void addComponentsToRightPanels() {
		JHeader.setBackground(getBackgroundPurpol());
		JHeader.setPreferredSize(new Dimension(550,100));
		new HomeContent().addComponentsToHome(JPcontentPnae ,JHeader);
		
		
		
		center.add(JHeader);
		center.add(JPcontentPnae);
		
		DashHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(DashHome).AccueilpnMouseEntered(evt);
            }
			public void mouseExited(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(DashHome).AccueilpnMouseExited(evt);
	        }
			public void mouseClicked(java.awt.event.MouseEvent evt) {
//				here I will add a part that shows the count of etudiant, prof and classes
				DashHome.setBackground(new java.awt.Color(150, 42, 100));
				new HomeContent().addComponentsToHome(JPcontentPnae ,JHeader);
			}
		});
		

		JPProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPProf).AccueilpnMouseEntered(evt);
            }
			public void mouseExited(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPProf).AccueilpnMouseExited(evt);
	        }
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JPProf.setBackground(new java.awt.Color(150, 42, 100));
				new ProfClassAdmin(JHeader,JPcontentPnae).AddContentPaneTop(evt);
			}
		});
		
		JPEtudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPEtudiant).AccueilpnMouseEntered(evt);
            }
			public void mouseExited(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPEtudiant).AccueilpnMouseExited(evt);
	        }
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JPEtudiant.setBackground(new java.awt.Color(150, 42, 100));
				new EtudiantClassAdimn(JHeader,JPcontentPnae).AddContentPaneTop(evt);
			}
		});
		
		JPClasse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPClasse).AccueilpnMouseEntered(evt);
            }
			public void mouseExited(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPClasse).AccueilpnMouseExited(evt);
	        }
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JPClasse.setBackground(new java.awt.Color(150, 42, 100));
				new ClasseClassAdmin(JHeader,JPcontentPnae).AddContentPaneTop(evt);
			}
			});
		
		JPchat.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPchat).AccueilpnMouseEntered(evt);
            }
			public void mouseExited(java.awt.event.MouseEvent evt) {
                new JpanelMouseEvent(JPchat).AccueilpnMouseExited(evt);
	        }
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				JPchat.setBackground(new java.awt.Color(150, 42, 100));
				try {
					
					new CallClient().RunChat(JPcontentPnae,JHeader,name);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
			
			
		});
	}
	
	private void addActionEvent() {
	}
	private void setLocationAndSize() {

		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}


}
