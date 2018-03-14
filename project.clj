(defproject org.clojars.diogok/cljts "0.5.1"
  :description "Clojure wrapper of JTS, implements the Simple Feature Spec of Open Geospatial Consortium (OGC)."
  :url "http://github.com/diogok/cljts"
  :license "Distributed under the Eclipse Public License, the same as Clojure."
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.vividsolutions/jts "1.13"]
                 [org.geotools/gt-geojson "16.0"]
                 [org.geotools/gt-geometry "16.0"]
                 [org.geotools/gt-shapefile "16.0"]
                 [org.geotools/gt-epsg-hsql "16.0"]
                 [org.geotools/gt-referencing "16.0"]]
  :repositories [["osgeo" "http://download.osgeo.org/webdav/geotools/"]
                 ["clojars" {:sign-releases false}]]
  :profiles {:dev {:dependencies [[midje "1.8.2"]]
                   :plugins [[lein-midje "3.2"]]}}
  :warn-on-reflection true)
