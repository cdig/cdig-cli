(ns cdig.svga
  (:require
   [cdig.io :as io]))

(def source-url "https://raw.githubusercontent.com/cdig/svga-starter/v3/dist/")
(def source-files ["cdig.json" "gulpfile.coffee" "package.json" "source/config.coffee" "source/symbol.coffee"])

(defn new-project
  []
  (if (io/path-exists? "cdig.json")
    (println "This folder already contains an SVGA project")
    (do
     (println (str "Generating an SVGA"))
     (dorun (map #(io/curl (str source-url %) %) source-files))
     (io/mkdir "resources"))))
     
(defn update-project
  []
  (println "Updating...")
  (io/rm "node_modules")
  (dorun (map #(io/curl (str source-url %) %) source-files)))

(defn v3->v4
  []
  (println "Hold on to your butts...")
  nil)
