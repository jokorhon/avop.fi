(ns avopfi.test.fixtures)

(def opiskeluoikeus-data-fixture
  {
    :id "avopOa1", 
    :kunta {
      :id "091",
      :nimi {
        "sv" "Helsingfors", 
        "fi" "Helsinki"
      }
    }, 
    :kieli "fi",
    :koulutus {
      :id "621702", 
      :nimi {
        "en" "BA (Poly), Cultural Manager", 
        "fi" "Kulttuurituottaja (AMK)", 
        "sv" "Kulturproducent (YH)"
      }
    }, 
    :koulutusmuoto 0,
    :opiskeluoikeustyyppi "1",
    :laajuus 240,
    :oppilaitos {
      :id "10065", 
      :nimi {
        "en" "Helsinki Metropolia University of Applied Sciences", 
        "fi" "Metropolia Ammattikorkeakoulu"
      }
    }
  }
)