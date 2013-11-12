package fr.istic.taa.yeoman;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Cardio
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected double frequency;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne(mappedBy = "cardio") 
	protected PointGPS pointGPS;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long id = 0L;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Cardio(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetPointGPS(PointGPS myPointGPS) {
		if (this.pointGPS != myPointGPS) {
			if (myPointGPS != null){
				if (this.pointGPS != myPointGPS) {
					PointGPS oldpointGPS = this.pointGPS;
					this.pointGPS = myPointGPS;
					if (oldpointGPS != null)
						oldpointGPS.unsetCardio();
				}
			}
		}	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public double getFrequency() {
		return this.frequency;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public PointGPS getPointGPS() {
		return this.pointGPS;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setFrequency(double myFrequency) {
		this.frequency = myFrequency;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setPointGPS(PointGPS myPointGPS) {
		this.basicSetPointGPS(myPointGPS);
		myPointGPS.basicSetCardio(this);
			
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetFrequency() {
		this.frequency = 0.0;	
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetPointGPS() {
		if (this.pointGPS == null)
			return;
		PointGPS oldpointGPS = this.pointGPS;
		this.pointGPS = null;
		oldpointGPS.unsetCardio();	
	}
	
}

