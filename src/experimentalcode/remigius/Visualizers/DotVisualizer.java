package experimentalcode.remigius.Visualizers;

import org.apache.batik.util.SVGConstants;
import org.w3c.dom.Element;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

import de.lmu.ifi.dbs.elki.data.DoubleVector;
import de.lmu.ifi.dbs.elki.database.Database;
import de.lmu.ifi.dbs.elki.visualization.css.CSSClassManager.CSSNamingConflict;
import de.lmu.ifi.dbs.elki.visualization.svg.SVGSimpleLinearAxis;
import de.lmu.ifi.dbs.elki.visualization.svg.SVGPlot;
import experimentalcode.remigius.Visualization;
import experimentalcode.remigius.VisualizationManager;
import experimentalcode.remigius.Visualizer;

public class DotVisualizer<O extends DoubleVector> extends Visualizer<O> {

	private EventListener hoverer;
	
	public DotVisualizer(Database<O> database, VisualizationManager<O> v){
		super(database, v);
//		this.hoverer = new ToolTipListener(v.getDocument());
	}

	@Override
	protected Visualization<O> visualize(SVGPlot svgp, Element layer, int dimx,
			int dimy) {
		try {
			SVGSimpleLinearAxis.drawAxis(svgp, layer, scales[dimx], 0, 1, 1, 1, true, true);
			SVGSimpleLinearAxis.drawAxis(svgp, layer, scales[dimy], 0, 1, 0, 0, true, false);
			svgp.updateStyleElement();
			
		} catch (CSSNamingConflict e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int id : database.getIDs()){

			Element dot = SHAPEGEN.createDot(svgp.getDocument(), getPositioned(database.get(id), dimx), (1 - getPositioned(database.get(id), dimy)), id, dimx, dimy);	
						EventTarget targ = (EventTarget) dot;
						targ.addEventListener(SVGConstants.SVG_MOUSEOVER_EVENT_TYPE, hoverer, false);
						targ.addEventListener(SVGConstants.SVG_MOUSEOUT_EVENT_TYPE, hoverer, false);
						targ.addEventListener(SVGConstants.SVG_CLICK_EVENT_TYPE, hoverer, false);
						layer.appendChild(dot);

			layer.appendChild(
					dot
			);
		}
		return new Visualization<O>(this, dimx, dimy, layer);
	}
	
	public String toString(){
		return "Dots";
	}
}
