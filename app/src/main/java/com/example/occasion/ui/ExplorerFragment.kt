
package com.example.occasion.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.button.MaterialButtonToggleGroup
import com.example.occasion.R

class ExplorerFragment : Fragment() {

    private lateinit var toggleButton: MaterialButtonToggleGroup
    private lateinit var createCommunityButton: Button
    private lateinit var seeLessButton: Button
    private lateinit var chipCommunityGroup: ChipGroup
    private lateinit var chipInterestsGroup: ChipGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_explorer, container, false)

        // Inicializações das views
        toggleButton = view.findViewById(R.id.toggle_button)
        createCommunityButton = view.findViewById(R.id.create_community_btn)
        seeLessButton = view.findViewById(R.id.see_less_btn)
        chipCommunityGroup = view.findViewById(R.id.chip_community_group)
        chipInterestsGroup = view.findViewById(R.id.chip_interests_group)

        // Configuração dos listeners de clique
        createCommunityButton.setOnClickListener {
            // Manipula o clique no botão "Crie sua comunidade"
            Toast.makeText(requireContext(), "Botão Criar Comunidade Clicado", Toast.LENGTH_SHORT).show()
            // Adicione sua lógica aqui para navegar ou realizar uma ação
        }

        seeLessButton.setOnClickListener {
            // Manipula o clique no botão "Ver Menos"
            Toast.makeText(requireContext(), "Botão Ver Menos Clicado", Toast.LENGTH_SHORT).show()
            // Adicione sua lógica aqui para mostrar menos conteúdo ou realizar uma ação
        }

        // Listener para alteração de seleção no grupo de chips de comunidade
        chipCommunityGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            chip?.let {
                Toast.makeText(requireContext(), "Comunidade Selecionada: ${it.text}", Toast.LENGTH_SHORT).show()
                // Adicione sua lógica aqui para lidar com a mudança de seleção
            }
        }

        // Listener para alteração de seleção no grupo de chips de interesses
        chipInterestsGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            chip?.let {
                Toast.makeText(requireContext(), "Interesse Selecionado: ${it.text}", Toast.LENGTH_SHORT).show()
                // Adicione sua lógica aqui para lidar com a mudança de seleção
            }
        }

        return view
    }
}
