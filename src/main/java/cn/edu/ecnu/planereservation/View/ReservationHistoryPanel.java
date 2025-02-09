/*
 * Created by JFormDesigner on Thu Dec 24 22:34:57 CST 2020
 */

package cn.edu.ecnu.planereservation.View;

import cn.edu.ecnu.planereservation.Controller.AirportController;
import cn.edu.ecnu.planereservation.Controller.FavouriteController;
import cn.edu.ecnu.planereservation.Controller.FlightSystemFacade;
import cn.edu.ecnu.planereservation.Controller.ReservationHistoryController;
import cn.edu.ecnu.planereservation.Model.AirportModel;
import cn.edu.ecnu.planereservation.Model.Joined.ReservationDetailModel;
import cn.edu.ecnu.planereservation.Util.Const;
import cn.edu.ecnu.planereservation.Util.Utils;
import cn.edu.ecnu.planereservation.View.Components.ConfirmDialog;
import cn.edu.ecnu.planereservation.View.Components.ConfirmableFrame;
import cn.edu.ecnu.planereservation.View.Components.InfoDialogue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/**
 * @author
 */
@Component
@Slf4j
public class ReservationHistoryPanel extends JPanel implements ConfirmableFrame {
    public ReservationHistoryPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - unknown
		panelHistory = new JPanel();
		var labelUI7 = new JLabel();
		scrollPane2 = new JScrollPane();
		tableDetail = new JTable();
		btnCancelReservation = new JButton();
		btnAddFavourite = new JButton();
		var labelUI9 = new JLabel();
		txtBeginDate = new JFormattedTextField();
		var labelUI10 = new JLabel();
		txtEndDate = new JFormattedTextField();
		scrollPane3 = new JScrollPane();
		listReservation = new JList<>();
		var labelUI11 = new JLabel();
		txtSearch = new JTextField();
		labHint = new JLabel();
		comboFilter = new JComboBox<>();
		var labelUI12 = new JLabel();
		panelTracking = new JPanel();
		var labelUI13 = new JLabel();
		labTrackStatus = new JLabel();
		var labelUI14 = new JLabel();

		//======== this ========
		setPreferredSize(new Dimension(1120, 606));
		setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
		javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax
		. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
		. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
		. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .
		PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .
		equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
		setLayout(null);

		//======== panelHistory ========
		{
			panelHistory.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.setLayout(null);

			//---- labelUI7 ----
			labelUI7.setText("Here's the reservations you made before. You can select one to view reservation detail and cancel or rearrange it.");
			labelUI7.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labelUI7);
			labelUI7.setBounds(30, 25, 880, 18);

			//======== scrollPane2 ========
			{

				//---- tableDetail ----
				tableDetail.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null},
						{null, null},
					},
					new String[] {
						"Key", "Value"
					}
				) {
					boolean[] columnEditable = new boolean[] {
						false, false
					};
					@Override
					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return columnEditable[columnIndex];
					}
				});
				tableDetail.setRowHeight(24);
				scrollPane2.setViewportView(tableDetail);
			}
			panelHistory.add(scrollPane2);
			scrollPane2.setBounds(565, 60, 555, 400);

			//---- btnCancelReservation ----
			btnCancelReservation.setText("Cancel Reservation");
			btnCancelReservation.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(btnCancelReservation);
			btnCancelReservation.setBounds(920, 570, 198, 36);

			//---- btnAddFavourite ----
			btnAddFavourite.setText("Add to Favourite");
			btnAddFavourite.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(btnAddFavourite);
			btnAddFavourite.setBounds(710, 570, 198, 36);

			//---- labelUI9 ----
			labelUI9.setText("Date Range:");
			labelUI9.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labelUI9);
			labelUI9.setBounds(30, 65, 120, 18);

			//---- txtBeginDate ----
			txtBeginDate.setPreferredSize(new Dimension(70, 30));
			panelHistory.add(txtBeginDate);
			txtBeginDate.setBounds(120, 60, 170, 30);

			//---- labelUI10 ----
			labelUI10.setText("To");
			labelUI10.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labelUI10);
			labelUI10.setBounds(305, 65, 25, 18);

			//---- txtEndDate ----
			txtEndDate.setPreferredSize(new Dimension(70, 30));
			panelHistory.add(txtEndDate);
			txtEndDate.setBounds(350, 60, 170, 30);

			//======== scrollPane3 ========
			{

				//---- listReservation ----
				listReservation.setFont(new Font("SF Pro Text", Font.BOLD, 16));
				listReservation.setFixedCellHeight(36);
				listReservation.setModel(new AbstractListModel<String>() {
					String[] values = {
						"Reservation at 2020-12-01 23:23:23 (FN001 \u9648\u4fca\u6f7c)",
						"Reservation at 2020-12-01 23:23:23 (FN001 \u8c22\u5609\u4e1c)"
					};
					@Override
					public int getSize() { return values.length; }
					@Override
					public String getElementAt(int i) { return values[i]; }
				});
				scrollPane3.setViewportView(listReservation);
			}
			panelHistory.add(scrollPane3);
			scrollPane3.setBounds(25, 165, 500, 395);

			//---- labelUI11 ----
			labelUI11.setText("Search:");
			labelUI11.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labelUI11);
			labelUI11.setBounds(30, 110, 60, 30);

			//---- txtSearch ----
			txtSearch.setPreferredSize(new Dimension(70, 30));
			panelHistory.add(txtSearch);
			txtSearch.setBounds(120, 110, 170, 30);

			//---- labHint ----
			labHint.setText("Hint text");
			labHint.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labHint);
			labHint.setBounds(25, 580, 670, 20);

			//---- comboFilter ----
			comboFilter.setModel(new DefaultComboBoxModel<>(new String[] {
				"All",
				"Finished",
				"Canceled"
			}));
			panelHistory.add(comboFilter);
			comboFilter.setBounds(350, 110, 170, 30);

			//---- labelUI12 ----
			labelUI12.setText("Status");
			labelUI12.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labelUI12);
			labelUI12.setBounds(305, 116, 40, 18);

			//======== panelTracking ========
			{
				panelTracking.setLayout(null);

				//---- labelUI13 ----
				labelUI13.setText("Reservation Progress:");
				labelUI13.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				panelTracking.add(labelUI13);
				labelUI13.setBounds(0, 0, 185, 30);

				//---- labTrackStatus ----
				labTrackStatus.setText("PURCHASED");
				labTrackStatus.setFont(new Font("SF Pro Text", Font.BOLD | Font.ITALIC, 24));
				panelTracking.add(labTrackStatus);
				labTrackStatus.setBounds(150, -5, 265, 35);

				//---- labelUI14 ----
				labelUI14.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				labelUI14.setText("Available reservation status are: Purchased, Seat Locked, Checked In, Finished, Canceled.");
				panelTracking.add(labelUI14);
				labelUI14.setBounds(0, 40, 540, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panelTracking.getComponentCount(); i++) {
						Rectangle bounds = panelTracking.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panelTracking.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panelTracking.setMinimumSize(preferredSize);
					panelTracking.setPreferredSize(preferredSize);
				}
			}
			panelHistory.add(panelTracking);
			panelTracking.setBounds(new Rectangle(new Point(565, 485), panelTracking.getPreferredSize()));

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panelHistory.getComponentCount(); i++) {
					Rectangle bounds = panelHistory.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panelHistory.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panelHistory.setMinimumSize(preferredSize);
				panelHistory.setPreferredSize(preferredSize);
			}
		}
		add(panelHistory);
		panelHistory.setBounds(0, 0, 1133, 631);

		setPreferredSize(new Dimension(1120, 610));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - unknown
	private JPanel panelHistory;
	private JScrollPane scrollPane2;
	private JTable tableDetail;
	private JButton btnCancelReservation;
	private JButton btnAddFavourite;
	private JFormattedTextField txtBeginDate;
	private JFormattedTextField txtEndDate;
	private JScrollPane scrollPane3;
	private JList<String> listReservation;
	private JTextField txtSearch;
	private JLabel labHint;
	private JComboBox<String> comboFilter;
	private JPanel panelTracking;
	private JLabel labTrackStatus;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    @Autowired
    FlightSystemFacade flightSystemFacade;

    @Autowired
    ReservationHistoryController reservationHistoryController;

    @Autowired
    AirportController airportController;

    @Autowired
	FavouriteController favouriteController;

    private Boolean isFirstLoad = true;
    private ArrayList<ReservationDetailModel> allReservations;
    private ArrayList<ReservationDetailModel> activeReservations;

    private final LinkedHashMap<String, String> detailMap = new LinkedHashMap<>() {{
        put("====== Reservation Info ======", "========================");
        put("Reservation ID", "");
        put("Reservation Date & Time", "");
        put("Order Status", "");
        put("Original Price", "");
        put("Actual Price", "");
		put("Discount", "");
        put("Payment method", "");
        put("Payment Order Number", "");
        put("====== Flight Detail ======", "========================");
        put("Flight Number", "");
        put("Model", "");
        put("Departure Airport", "");
        put("Arrival Airport", "");
        put("Departure Date & Time", "");
        put("Flight Duration", "");
        put("Arrival Date & Time", "");
        put("Seat Class", "");
        put("====== Passenger Info ======", "========================");
        put("Passenger Name", "");
        put("Passenger ID", "");
        put("Passenger Phone", "");
    }};

    class ReservationListCellRenderer extends DefaultListCellRenderer {

        private ArrayList<ReservationDetailModel> reservations;
        public ReservationListCellRenderer(ArrayList<ReservationDetailModel> reservations) {
            this.reservations = reservations;
        }

        @Override
        public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            java.awt.Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );

            if(index >= 0 && index < reservations.size()) {
                if (reservationHistoryController.getReservationStatus(reservations.get(index).getState()) ==
                        ReservationHistoryController.ReservationStatus.Canceled) {
//                c.setBackground(Color.LIGHT_GRAY);
                    c.setFont(c.getFont().deriveFont(Font.ITALIC));
                }
            }

            return c;
        }
    }

    public void fillList() {
        listReservation.setModel(new DefaultListModel<>());
        listReservation.clearSelection();
        DefaultListModel<String> model = (DefaultListModel<String>) listReservation.getModel();
        model.clear();
        activeReservations = (ArrayList<ReservationDetailModel>) allReservations.stream().filter(one -> {
            switch (comboFilter.getSelectedIndex()) {
                case (1):
                    return reservationHistoryController.getReservationStatus(one.getState()) ==
                            ReservationHistoryController.ReservationStatus.Finished;
                case (2):
                    return reservationHistoryController.getReservationStatus(one.getState()) ==
                            ReservationHistoryController.ReservationStatus.Canceled;
                default:
                    return true;
            }
        }).collect(Collectors.toList());
        activeReservations.forEach(one -> {
            model.addElement(String.format("Reservation at %s (%s %s)", one.getDatetime(), one.getFlightNumber(), one.getName()));
        });
        listReservation.setCellRenderer(new ReservationListCellRenderer(activeReservations));
        listReservation.updateUI();
    }

    public ReservationDetailModel getSelectedDetail() {
    	if (listReservation.getSelectedIndex() == -1) {
    		return null;
		}
		ReservationDetailModel rd = activeReservations.get(listReservation.getSelectedIndex());
		return rd;
	}

    public void fillDetailTable() {
        DefaultTableModel model = (DefaultTableModel) tableDetail.getModel();
        model.setRowCount(0);
        if(listReservation.getSelectedIndex() == -1) {
            // No reservation;
            return;
        }
        ReservationDetailModel rd = activeReservations.get(listReservation.getSelectedIndex());
        AirportModel departureAirport = airportController.getAirportByAirportId(rd.getFlyFromAirportId());
        AirportModel arrivalAirport = airportController.getAirportByAirportId(rd.getFlyToAirportId());
        detailMap.put("Reservation ID", String.valueOf(rd.getReservationId()));
        detailMap.put("Reservation Date & Time", rd.getDatetime());
        detailMap.put("Order Status", reservationHistoryController.getReservationStatus(rd.getState()).name());
        detailMap.put("Flight Number", rd.getFlightNumber());
        detailMap.put("Model", rd.getModel());
        detailMap.put("Departure Airport", String.format("%s (%s)", departureAirport.getCode(), departureAirport.getAirportName()));
        detailMap.put("Arrival Airport", String.format("%s (%s)", arrivalAirport.getCode(), arrivalAirport.getAirportName()));
        detailMap.put("Departure Date & Time", rd.getDepartureDate() + " " + rd.getDepartureTime());
        detailMap.put("Flight Duration",  Utils.minuteToHourFormatter(rd.getFlightDurationMinutes()));
        detailMap.put("Arrival Date & Time", Utils.getArrivalDatetime(rd.getDepartureDate().toString(),
                rd.getDepartureTime().toString(),
                rd.getFlightDurationMinutes()));
        detailMap.put("Seat Class", rd.getType().name());
        detailMap.put("Passenger Name", rd.getName());
        detailMap.put("Passenger ID", rd.getIdentityNumber());
        detailMap.put("Passenger Phone", rd.getPhone());
        detailMap.put("Original Price", String.valueOf(rd.getPrice()));
        // todo: Real price and discount
        detailMap.put("Actual Price", rd.getPaymentId() == 0 ? String.valueOf(rd.getPrice()): String.valueOf(rd.getRealPrice()));
        detailMap.put("Payment method", rd.getPaymentMethod().name());
        detailMap.put("Payment Order Number", rd.getOrderNumber());
		detailMap.put("Discount", rd.getDiscountStrategy().length() == 0 ? "No Discount" : rd.getDiscountStrategy());
        for (String one: detailMap.keySet()) {
            model.addRow(new String[]{one, (String) detailMap.get(one)});
        }
        tableDetail.updateUI();
        labTrackStatus.setText(reservationHistoryController.getTrackingStatus(rd).name().replace('_', '-'));
    }

    private void updateUIStatus() {
		btnCancelReservation.setEnabled(false);
		btnCancelReservation.setText("Cancel Reservation");
		panelTracking.setVisible(false);
		btnAddFavourite.setEnabled(false);
		if (getSelectedDetail() == null) {
			return;
		}
		btnAddFavourite.setEnabled(true);
		panelTracking.setVisible(true);
		if (getSelectedDetail().getState() != Const.RESERVATION_STATE_CANCELED) {
			btnCancelReservation.setEnabled(true);
		}
	}

	private void tryCancelReservation() {
		ConfirmDialog c = new ConfirmDialog("Doing so will cancel your reservation. Do you confirm?", 1, this);
		c.setVisible(true);
	}

	private void addFavourite() {
    	favouriteController.registerFavourite(getSelectedDetail().getFlightDescriptionId(),
											  getSelectedDetail().getPassengerId());
    	new InfoDialogue("Registered to favourite. You can check it out in the 'Buy Tickets in One Click' tab.").setVisible(true);
	}

	@Override
	public void onConfirmed(int confirmationCode) {
		switch (confirmationCode) {
			case 1:
				// Confirm cancel reservation.
				reservationHistoryController.cancelReservationById(getSelectedDetail().getReservationId());
				refresh();
				updateUIStatus();
				break;
			default:
				break;
		}
	}

	public void refresh() {
        allReservations = flightSystemFacade.getPreviousReservationDetails();
        allReservations.sort(new Comparator<ReservationDetailModel>() {
            @Override
            public int compare(ReservationDetailModel t0, ReservationDetailModel t1) {
                return t1.getDatetime().compareTo(t0.getDatetime());
            }
        });
        fillList();
        log.info("Updating history.");
    }

    public void addListeners() {
        btnCancelReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	tryCancelReservation();
            }
        });

        listReservation.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                fillDetailTable();
				updateUIStatus();
            }
        });

        comboFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fillList();
				updateUIStatus();
            }
        });

        btnAddFavourite.addActionListener(e -> addFavourite());
    }

    public void load() {
        log.info("Initializing reservation history.");

        labHint.setText("Canceled reservations are italic. Add history record to favourite to buy tickets in one click.");

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		txtBeginDate.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(df)));
		txtEndDate.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(df)));
        if (isFirstLoad) {
            addListeners();
        }

        updateUIStatus();
    }
}
